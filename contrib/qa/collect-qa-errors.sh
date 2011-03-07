#!/bin/bash

# A little script outputting information on all recipes with QA issues

bb_tmp_dir=$(bitbake -e | grep 'TMPDIR="' | sed -e s/TMPDIR=// \
                                                -e s/\"//g)

# report each log.qa_package in temp dir
for log_dir in ${bb_tmp_dir}/work/*/*/temp/log.qa_package ; do
	str=${log_dir%/*}
	str=${str%/*}
	echo $str
done


