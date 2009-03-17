LICENSE = "None"
DESCRIPTION = "A tool to extract the ttsystem images into their components." 

SRC_URI = "svn://svn.opentom.org/opentom/trunk/;module=ttimgextract;proto=http"

PV = "0.0+svn${SRCDATE}"
S = "${WORKDIR}/${PN}"


do_compile() {
        ${CC} -o ttimgextract ttimgextract.c -DPATH_MAX=4096 ${TARGET_CC_ARCH}
}

do_install () {
        install -d ${D}${bindir}
        install -m 0755 ${S}/ttimgextract ${D}${bindir}/
}
