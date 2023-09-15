# TweetReverse Web Services

## Features

- Authentication with JWT and Email validation. Password change.
- Users can Add tweets, Like, Retweet, Reply, Quote tweets, Schedule tweets.
- Users can Delete tweets, Send tweet via Direct Message, Add tweet to Bookmarks.
- Users can Create Lists, Edit Lists, Add other users to Lists, Follow List, Pin Lists.
- Users get notifications when someone subscribed, retweet or liked tweet.
- Users can add Images to tweet, Create Poll and vote, Post tweets with link preview, Posts tweets with YouTube video link.
- Websocket online chats.
- Private user profile and lists.
- Account Settings.
- Users can subscribe to each other.
- User can edit profile.
- User can block and mute other users.
- Users can customize site color scheme and color background.
- Users can search tweets by hashtags and search other users and users tweets.
- All images downloads on Amazon S3 bucket.

## How it works
1. Installation
2. Use `lombok plugin`
3. Build the project with maven on `Makefile` file.
4. Make container with `docker-compose` for `postgres`, `pgadmin`, `zipkin`, `rabbitmq` service.
5. Open `http://localhost:5050/browser/` then create databases like `user`, `tweet`, `chat`, `lists`, `notification`, `tag`, `topic`.
6. Sign Up for [AWS account](https://portal.aws.amazon.com/billing/signup#/start), then create [AWS S3 bucket](https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-bucket-overview.html), then add a [public access policy](https://docs.aws.amazon.com/AmazonS3/latest/userguide/access-policy-language-overview.html) ([github example](https://stackoverflow.com/questions/58580042/how-to-set-public-read-only-access-on-amazon-s3-bucket#:~:text=To%20make%20objects%20publicly%20accessible%2C%20use%20a%20policy%20like%20this%3A)).
   ```json
   {
     "Version": "2023-09-15",
     "Statement": [
       {
         "Sid": "PublicRead",
         "Effect": "Allow",
         "Principal": "*",
         "Action": ["s3:GetObject", "s3:GetObjectVersion"],
         "Resource": "arn:aws:s3::tweetversestorage/*"
       }
     ]
   }
   ```
7. Get [AWS keys](https://supsystic.com/documentation/id-secret-access-key-amazon-s3/) and add to the `application.properties`.
   ```yml
   amazon:
      aws:
        access-key: **********
        secret-key: ***************
      s3:
        bucket:
          name: tweetversestorage
   ```
8. Create [Google API keys](https://developers.google.com/youtube/v3/getting-started#before-you-start) then add key to the `tweet-service.yml` configuration file.
9. Add gmail account and password to the `email-service.yml` configuration file then go to [important](https://myaccount.google.com/u/2/lesssecureapps) and change to "Allow less secure apps: ON".
10. Run all services in this order: `eureka-server`, `config-server`, `api-gateway`, `user-service`, and `other-service`.
11. See [TweetVerse Frontend](https://github.com/gusrill/tweetverse_reactjs).

```bash
# login
username: johndoe@gmail.com
password: qwerty123
```
