def send_message_to_slack(text):
    from urllib import request, parse
    import json

    post = {"text": "{0}".format(text)}

    try:
        json_data = json.dumps(post)
        req = request.Request("https://hooks.slack.com/services/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",
                              data=json_data.encode('ascii'),
                              headers={'Content-Type': 'application/json'})
        resp = request.urlopen(req)
    except Exception as em:
        print("EXCEPTION: " + str(em))

send_message_to_slack('Docker Pipeline is completed...................')