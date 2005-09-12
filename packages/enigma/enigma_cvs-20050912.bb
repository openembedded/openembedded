CVSDATE = "20050912"
include enigma_cvs.bb
SRC_URI_append = " file://network_fix.diff;patch=1;pnum=1"
