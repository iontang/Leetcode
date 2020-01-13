//
// Created by admin on 2019/8/16.
//

#ifndef LEETCODE_DESIGTWITTER_H
#define LEETCODE_DESIGTWITTER_H

#endif //LEETCODE_DESIGTWITTER_H



//class Twitter {
//    unordered_map<int, priority_queue<int>> userid_tweetid; // 一个用户对应的推特流，会存在不同用户的，最多10条最新的，用小根堆维护。 // 这种冗杂的数据结构会使得一个粉丝取关后很难从中删除推文。所以需要分开并且添加推文时间
//    unordered_map<int, vector<int>> userid_followerid; // 一个用户对应粉丝。
//public:
//
//    /** Initialize your data structure here. */
//    Twitter() {
//
//    }
//    /** Compose a new tweet.
//     * userId新发一条推特的时候，会加入到
//     **/
//    void postTweet(int userId, int tweetId) {
//        userid_tweetid[userId].push(tweetId);
//        // 对于每一个粉丝，都需要添加该条推特到他们到浏览目录。
//        for (auto id : userid_followerid[userId]) {
//            userid_tweetid[id].push(tweetId);
//        }
//    }
//
//    /** Retrieve the 10 most recent tweet ids in the user's news feed.
//     * Each item in the news feed must be posted by users who the user followed or by the user herself.
//     * Tweets must be ordered from most recent to least recent.
//     **/
//    vector<int> getNewsFeed(int userId) {
//        auto pq = userid_tweetid[userId];
//        vector<int> result;
//        while (!pq.empty() && result.size()<11) {
//            result.push_back(pq.top());
//            pq.pop();
//        }
//        return result;
//    }
//
//    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
//    void follow(int followerId, int followeeId) {
//        userid_followerid[followeeId].push_back(followerId); //如果一个人突然follower一个对象的时候，需要把该对象的所有推特按照时间顺序添加到粉丝的堆中
//    }
//
//    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
//    void unfollow(int followerId, int followeeId) {
//        userid_followerid.erase(followeeId);  // 如果一个人突然取消关注一个对象的时候，需要把该对象的所有推特从Ta的堆中取出来。
//    }
//};


#include <map>
#include <unordered_set>

using namespace std;

class Twitter{

    struct Tweet {
        int time;
        int id;
        Tweet(int time, int id) :time(time), id(id) {}
    };

    unordered_map<int, vector<Tweet>> tweets;
    unordered_map<int, unordered_set<int> > following;
    int time;

public:
    Twitter(): time(0) {}

    void postTweet(int userId, int tweetId) {
        tweets[userId].emplace_back(time++,tweetId);
    }

    vector<int> getNewsFeed(int userId) {
        vector<pair<Tweet*,Tweet*>> h;
        for (auto& u: following[userId]) {
            auto& t = tweets[u];
            if (t.size()>0) {
                h.emplace_back(t.data(),t.data()+t.size()-1);
            }
        }

        auto& t =tweets[userId];
        if (t.size() > 0)
            h.emplace_back(t.data(), t.data()+t.size() - 1);

        auto f = [](const std::pair<Tweet*, Tweet*>& x, const std::pair<Tweet*, Tweet*>& y) {
            return x.second->time < y.second->time;
        };
        std::make_heap(h.begin(), h.end(), f);

        const int n = 10;
        std::vector<int> o;
        o.reserve(n);
        for (int i = 0; (i < n) && !h.empty(); ++i)
        {
            std::pop_heap(h.begin(), h.end(), f);

            auto& hb = h.back();
            o.push_back(hb.second->id);

            if (hb.first == hb.second--)
                h.pop_back();
            else
                std::push_heap(h.begin(), h.end(), f);
        }
        return o;

    }


    void follow(int followerId, int followeeId) {
        if (followerId != followeeId)
            following[followerId].insert(followeeId);
    }


    void unfollow(int followerId, int followeeId) {
        following[followerId].erase(followeeId);
    }

};