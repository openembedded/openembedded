include ctorrent.inc
PR = "r3"

SRC_URI += "file://nogetwd.patch;patch=1 \
	    file://crash.patch;patch=1 \
	    file://fmt.patch;patch=1 \
	    file://stall.patch;patch=1 \
	    file://tracker.patch;patch=1"
