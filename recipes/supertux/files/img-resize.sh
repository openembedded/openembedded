#!/bin/sh

conv() {

if [ ! -d org ]; then
    mkdir org
    mv *.jpg *.png org/
fi

for i in org/*; do
	b=`basename $i`
	ext=`expr "x$b" : 'x.*\.\(.*\)'`
	if [ "$ext" = "png" ]; then
	    if [ $b = "tux-life.png" ]; then
		cp $i _.png
	    else
		convert $i -resize 50% -colors 64 _.png
	    fi
	    pngcrush -q _.png $b
	elif [ "$ext" = "jpg" ]; then
		convert $i -resize 50% -quality 60 $b
	fi
done
rm _.png

}

conv
