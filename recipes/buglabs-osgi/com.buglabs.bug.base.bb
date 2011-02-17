require bug-osgi.inc
PR = "${INC_PR}.11+svnr${SRCREV}"
EXTRA_CP += "servlet-2.3.1"
DEPENDS += "com.buglabs.common com.buglabs.bug.jni.input  com.buglabs.bug.jni.common servlet2.3 com.buglabs.osgi.http"

SUBMODULE_bug20 = "molly"
SUBMODULE_beagleboard = "beagle"

SRC_URI = "svn://bugcamp.net/bug/trunk;module=${PN}.${SUBMODULE};proto=svn "
SRC_URI_bug = "svn://bugcamp.net/bug/tags/releases/R1.4.3;module=${PN};proto=svn"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/${PN}.${SUBMODULE}/"
JAVAC_OPTIONS="-source 1.6"
COMPATIBLE_MACHINE = "(bug|bug20|beagleboard)"
