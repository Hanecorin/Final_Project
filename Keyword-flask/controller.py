#-*- coding:utf-8 -*-
from flask import Flask, request, jsonify, render_template
from flask_cors import CORS
from dao import DAO

app = Flask(__name__)
app.config['DEBUG'] = True
CORS(app)

@app.route('/make-hashtag', methods=['post'])
def makeTag():
    # get 방식
    # doc = request.args.to_dict()['content']

    # post 방식
    doc = request.form.get('text')
    print("doc print test :", doc)
    dao = DAO()
    result = dao.keyword(doc)
    response = jsonify(message=result)
    # 리스트 출력
    # print("keyword() print test :", result)
    # return str(result)
    
    # 문자열 출력
    none_key = '적절한 키워드가 없습니다'
    if result != none_key:
        tag = ' '.join(result)
        print("keyword() print test :", tag)
        return response        
    else:
        print("keyword() print test :", result)
        return response

# >python controller.py
if __name__ == '__main__':
    dao = DAO()
    doc = ''
    dao.keyword(doc)
    app.run(debug=True, host='0.0.0.0', port=5000)