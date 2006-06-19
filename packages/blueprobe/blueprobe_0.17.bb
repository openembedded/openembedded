SECTION = "base"
LICENSE = "GPL"
inherit gpe

PR = "r2"

SRC_URI += "file://hx4700.patch;patch=1\
	    file://h2200-fixup.patch;patch=1\
            file://htcuniversal.patch;patch=1"
