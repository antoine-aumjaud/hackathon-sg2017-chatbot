#!/bin/sh

ps -ef | grep myProcessName | grep -v grep | awk '{print $2}' | xargs kill -9
git pull
./gradlew bootRun