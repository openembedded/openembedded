require hostap-daemon.inc

SRC_URI_append_nylon = "\
	file://hostap-no-bsd.patch;patch=1"


PR = "r2"
