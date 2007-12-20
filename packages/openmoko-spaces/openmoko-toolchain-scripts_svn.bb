DESCRIPTION = "Convenient scripts to be used with openmoko toolchain."
PR = "r1"

SRC_URI = "svn://svn.openmoko.org/developers/john_lee;module=toolkit;proto=http"

S = "${WORKDIR}/toolkit"

FILES_${PN} = "/"

do_install () {
	cp -dr ${S}/* ${D}
	find ${D} -name ".svn" | xargs rm -rf
	rm -r ${D}/patches
}
