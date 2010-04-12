require curl-common.inc
require curl-target.inc

SRC_URI += "file://curl-7.18.1-CVE-2009-2417.patch;patch=1;pnum=0"

PR = "${INC_PR}.2"

SRC_URI[tarball.md5sum] = "c389be5b0525276e58865956b7465562"
SRC_URI[tarball.sha256sum] = "b1f47a0177a5b13d317ab1f6570510502739909ede550e7da08ba814c3c73ae8"
