#!/bin/sh

INPUTS=inputs/*
mkdir usertest
for i in $INPUTS
	do
		filename=${i%.*}
		name=${filename##*/}
		echo "Testing input file $i"
		output="${name}Test.out"
		outtest="${name}.out"
		java -jar LittleCompiler.jar $i > usertest/$output
		tinySimulator.exe usertest/$output
	done
    
read -p "Waiting for input"