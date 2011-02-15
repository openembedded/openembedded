#!/bin/bash

# A little script outputting information on all recipes with QA errors

bb_tmp_dir=$(bitbake -e | grep 'TMPDIR="' | sed -e s/TMPDIR=// \
                                                -e s/\"//g)

# each temp dir is checked
for log_dir in ${bb_tmp_dir}/work/*/*/temp ; do
	# checked only log files
	for log_file in ${log_dir}/log.do_* ; do
		if [ -e  $log_file ] ; then
			qa_err=$(grep 'ERROR: QA' $log_file)
			if [[ -n  $qa_err ]] ; then
				# Bingo
				str=${log_file%/*}
				str=${str%/*}
				echo $str
				# output only one occurance per recipe
				break
			fi
		fi
	done
done


