require olsrd.inc
PR = "r2"

SRC_URI += "file://0.4.9-httpinfo-makefile.diff;patch=1"

do_compile() {
	oe_runmake OS=linux clean
	touch .depend
	touch src/cfgparser/.depend
	oe_runmake OS=linux all libs
}

SRC_URI[md5sum] = "593c0861fa10d2a8d0e7d8617479c5cf"
SRC_URI[sha256sum] = "b3404a5a5dd78c0e1ba12b8aa1445589fa7861fa4d9ecafb53b38be760876913"
