# Details

Functionality:

- The app should start on the Query Activity, which allows you to tap what you are looking for and get redirected to the PhotosListActivity
P.S. I had something crashing on my IDE when I tried to set the query edit text in the photoList supportBar. That's the reason why the    query is in a separate activity , so I could finish the basic functionality. It would have definetly been more effcient having all components in one activity.


Task undone:
 -All the Bonus task
 
(Post Submission update on 2018/10/18 10:53am) -Just realized that I forgot to setup the infinite scrolling. The method is already set in the presenter , just needed to add a listener in the activity to track end of page and set a treshold value to ultimately call the getmoreData method.

Time Tracking:
-I am sharing a github url for the project, and that should allow you to view the different commit and see how long it took me to complete what I've done (Approx 3 hours)

Personal Review:

Great take home assigment. I lost about 20-25 min trying to figure out why the response body of my retrofit call was null, and ultimately I needed to track it down with an HttpInterceptor, something I've never used before.
Besides that the whole implementation was done within 2:15h - 2:30h,and I used the rest of the time to review my code and try to fix the horizontal spacing in the RecyclerView.

Thank you and I am Looking forward to talking more about this assignment and get some feedback.

Library that I would have added if more time was allowed:
RxJava
EventBus


Github url : https://github.com/souley95/Take-Test


UPDATE : Implemented Infinite scroll and better design of RecyclerView
