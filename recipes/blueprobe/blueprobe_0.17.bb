require blueprobe.inc

PR = "r3"

SRC_URI += "file://hx4700.patch;patch=1 \
	    file://h2200-fixup.patch;patch=1 \
            file://htcuniversal.patch;patch=1 \
	    file://hwuart.patch;patch=1;pnum=2"
