# James image

inherit image

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL += "task-boot \
	    task-nas-server-everything \
	    task-mythtv \
	    task-internetserver \
	    task-mediaserver \
	    task-importmedia \
# stuff below needs a proper task
	    dropbear \
	    xinetd \
            util-linux-ng-mount util-linux-ng-umount \
	    screen \
	    cups procps\
	    xmltv \
	    midori \
	    lame \
	    libcwiid  wmgui wminput lswm \
	    w3cam  \
	   "

# the following packages still need some work and will (maybe?) 
# be added in due time
#	    motion \
#	    asterisk \
#	    ekiga \
#	    lcd4linux \
#	    mplayer \

export IMAGE_BASENAME = "james-image"
IMAGE_LINGUAS = ""


