require lighttpd.inc

PR = "${INC_PR}.1"

SRC_URI += "file://configure.in.patch;apply=yes \
	    file://mod_redirect.c.patch;apply=yes \
	    file://src-server.c.patch;apply=yes \
           "


SRC_URI[src.md5sum] = "5db3204d57436a032f899ff9dbce793f"
SRC_URI[src.sha256sum] = "97d0ac5957745eeaf311ec38ebbbf3b30a5316b01c320a759af47129c994c20c"
