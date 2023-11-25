from flask import Flask

app = Flask(__name__)


@app.route('/info', methods=['GET'])
def info():
    return {'message': 'erp-system'}


if __name__ == '__main__':
    app.run(debug=True)
