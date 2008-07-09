DESCRIPTION = "Convenient scripts to be used with openmoko toolchain."

PV = "0.0+svnr${SRCREV}"
PE = "1"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host;module=toolchain-scripts;proto=http"

S = "${WORKDIR}/toolchain-scripts"

FILES_${PN} = "/bin /scripts /* \
"

do_install () {
	install -d ${D}/doc
	cp -dr ${S}/* ${D}
	find ${D} -name ".svn" | xargs rm -rf
	rm -r ${D}/patches
	cd ${D} ; mv COPYING COPYING.MIT LICENSE README doc ; mv setup-env bin 
}
