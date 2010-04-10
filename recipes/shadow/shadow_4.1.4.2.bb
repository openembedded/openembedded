require shadow.inc

SRC_URI += " file://shadow.automake-1.11.patch;patch=1"

PR = "${INC_PR}.1"

SRC_URI[md5sum] = "d593a9cab93c48ee0a6ba056db8c1997"
SRC_URI[sha256sum] = "97987f6a7967a85e6aa0dba2a1d52db8bd69af5a717391de5693db768fb78990"
