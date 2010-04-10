require python-twisted_${PV}.bb

RDEPENDS_${PN} = ""

inherit native

do_stage() {
	distutils_stage_all
}

SRC_URI[md5sum] = "c85f151999df3ecf04c49a781b4438d2"
SRC_URI[sha256sum] = "e0602bb05e31f6100b6f9ab35cfa93ab9f7a1c50a351a0ddfcd236a923bddfb0"
