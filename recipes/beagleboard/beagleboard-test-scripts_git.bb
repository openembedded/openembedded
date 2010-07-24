DESCRIPTION = "BeagleBoard test scripts"
HOMEPAGE = "http://beagleboad.org/support"

SRC_URI = "git://gitorious.org/beagleboard-validation/scripts.git;protocol=git \
"

SRCREV = "4f4578e7423c5fb1f3364e1056d53dd3b792dc2a"
S = "${WORKDIR}/git"

do_install() {
  TEST_FILES=" \
    testled \
    testuserbtn \
    testaudio \
    testsvideo \
    readgpio \
    editbootscr \
  "
  install -d ${D}/${bindir}
  for i in ${TEST_FILES}; do
    install -m 0755 ${S}/${i} ${D}/${bindir}
  done
}

