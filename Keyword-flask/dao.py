class DAO:
    def __init__(self):
        return None

    def keyword(self, doc):
        # 라이브러리
        import numpy as np
        import itertools
        from konlpy.tag import Okt
        from sklearn.feature_extraction.text import CountVectorizer
        from sklearn.metrics.pairwise import cosine_similarity
        from sentence_transformers import SentenceTransformer
        
        # 내용작성
        # doc = input()
        
        # 명사만 추출
        okt = Okt()
        tokenized_doc = okt.pos(doc)
        tokenized_nouns = ' '.join([word[0] for word in tokenized_doc if word[1] == 'Noun'])

        # 명사 추출이 되는 경우
        if len(tokenized_nouns) != 0:
            # 1글자의 단어인 경우 의미없는 단어 추가 (∵ 단어 추출 과정에서 사용되는 CountVectorizer함수는 글자수가 2 이상인 단어부터 처리 가능)
            doc_add_pointless = []
            for data in tokenized_nouns.split():
                if len(data) == 1:
                    data = data + '뜗'
                    doc_add_pointless.append(data)
                else:
                    doc_add_pointless.append(data)
            doc_add_pointless = ' '.join(doc_add_pointless)
            
            # 단어 추출
            n_gram_range = (1, 1) # 조합할 단어 개수
            count = CountVectorizer(ngram_range=n_gram_range).fit([doc_add_pointless])
            candidates = count.get_feature_names_out()
            
            # 1글자 단어 뒤 의미 없는 단어 제거
            doc_remove_pointless = []
            for data in candidates:
                if data[-1] == '뜗':
                    data = data.replace('뜗', '')
                    doc_remove_pointless.append(data)
                else:
                    doc_remove_pointless.append(data)
                    
            # SBERT를 통한 추출 키워드 수치화
            model = SentenceTransformer('sentence-transformers/xlm-r-100langs-bert-base-nli-stsb-mean-tokens')
            doc_embedding = model.encode([doc])
            candidate_embeddings = model.encode(doc_remove_pointless)
            
            # 상위 키워드 키워드 출력 (최대 3개)
            top_n = 3
            distances = cosine_similarity(doc_embedding, candidate_embeddings)
            keywords = [doc_remove_pointless[index] for index in distances.argsort()[0][-top_n:]]
            
            # 텍스트 요약 작업에서 중복을 최소화 후 결과의 다양성 조정
            def mmr(doc_embedding, candidate_embeddings, words, top_n, diversity):

                # 문서와 각 키워드들 간의 유사도가 적혀있는 리스트
                word_doc_similarity = cosine_similarity(candidate_embeddings, doc_embedding)

                # 각 키워드들 간의 유사도
                word_similarity = cosine_similarity(candidate_embeddings)

                # 문서와 가장 높은 유사도를 가진 키워드의 인덱스를 추출
                # 만약, 2번 문서가 가장 유사도가 높았다면
                # keywords_idx = [2]
                keywords_idx = [np.argmax(word_doc_similarity)]

                # 가장 높은 유사도를 가진 키워드의 인덱스를 제외한 문서의 인덱스들
                # 만약, 2번 문서가 가장 유사도가 높았다면
                # ==> candidates_idx = [0, 1, 3, 4, 5, 6, 7, 8, 9, 10 ... 중략 ...]
                candidates_idx = [i for i in range(len(words)) if i != keywords_idx[0]]

                # 최고의 키워드는 이미 추출했으므로 top_n-1번만큼 아래를 반복
                # ex) top_n = 5라면, 아래의 loop는 4번 반복
                for _ in range(top_n - 1):
                    candidate_similarities = word_doc_similarity[candidates_idx, :]
                    target_similarities = np.max(word_similarity[candidates_idx][:, keywords_idx], axis=1)

                    # MMR을 계산
                    mmr = (1-diversity) * candidate_similarities - diversity * target_similarities.reshape(-1, 1)
                    mmr_idx = candidates_idx[np.argmax(mmr)]

                    # keywords & candidates를 업데이트
                    keywords_idx.append(mmr_idx)
                    candidates_idx.remove(mmr_idx)

                return [words[idx] for idx in keywords_idx]
            
            # 단순 결과 출력
            # result = mmr(doc_embedding, candidate_embeddings, doc_remove_pointless, top_n=len(keywords), diversity=0.2)
            # return result

            # 해시태그 처리
            before_tag = mmr(doc_embedding, candidate_embeddings, doc_remove_pointless, top_n=len(keywords), diversity=0.2)
            
            # 리스트 형식으로 출력
            after_tag = []
            for data in before_tag:
                data = '#' + data
                after_tag.append(data)
            return after_tag

            # 각각 출력
            # for data in before_tag:
            #     data = '#' + data
            #     after_tag = data
            # return after_tag

        # 명사 추출을 못한 경우
        else:
            result = '적절한 키워드가 없습니다'
            return result