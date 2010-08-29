require vala.inc
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "bdbd45ea446c11ccf58af86e49f2168c"
SRC_URI[archive.sha256sum] = "7377856c1ca6249ae6c6c654ba03ced6cbf84ac3e97f61f2dfbb210277e84a20"

# also register as Vala 1.0 to ease the transition
do_install_append() {
	install -m 0644 vala-0.10.pc ${D}${libdir}/pkgconfig/vala-1.0.pc
}
