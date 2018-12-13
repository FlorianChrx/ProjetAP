#! /bin/bash
for i in $(ls ./src | grep .java)
do 
	javac -cp ap.jar ./src/$i -d . -nowarn
done