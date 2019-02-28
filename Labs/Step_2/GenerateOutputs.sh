#!/bin/sh

echo aa
INPUTS=inputs/*
for i in $INPUTS
	do
		java -jar LittleCompiler.jar $i
	done
    
read -p "Waiting.."