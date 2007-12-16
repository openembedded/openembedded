DESCRIPTION = "Convenient scripts to be used with openmoko toolchain."
PACKAGE_ARCH = "all"

SRC_URI = "svn://svn.openmoko.org/developers/john_lee;module=toolkit;proto=http"
SRC_URI += "svn://svn.openmoko.org/trunk/src/target/OM-2007.2/applications;module=openmoko-sample2;proto=http"

SRCREV="3630"
FILES_${PN} = "/"

do_install () {
	(find ${WORKDIR} -type d -name ".svn" | xargs rm -rf) || true
	install -m 755 -d ${D}/share
	cp -dr ${WORKDIR}/toolkit/* ${D}
	cp -dr ${WORKDIR}/openmoko-sample2 ${D}/share
}
