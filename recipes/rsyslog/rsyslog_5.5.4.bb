require rsyslog.inc
PR = "${INC_PR}.1"

SRC_URI += " file://rsyslog-resume.patch "

SRC_URI[md5sum] = "824df2504955df1619e5ec2915d783aa"
SRC_URI[sha256sum] = "31853a551ea7ca960c59c9e33406b1748bdf311059c9d8a4ce98816d51b17cac"
