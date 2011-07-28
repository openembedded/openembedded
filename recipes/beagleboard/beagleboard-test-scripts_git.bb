## Reminder:  The correct spacing for a variable is FOO = "BAR"  in : PR="r1"
DESCRIPTION = "BeagleBoard test scripts"
HOMEPAGE = "http://beagleboad.org/support"
PR = "r4"

SRC_URI = "git://gitorious.org/~joelf/beagleboard-validation/validation-scripts.git;protocol=git \
"

SRCREV = "f7ba1b49190003af524f1a768ec887955a9994a0"
S = "${WORKDIR}/git"

inherit update-rc.d
INITSCRIPT_NAME = "flash-nand-fs.sh"
INITSCRIPT_PARAMS = "start 99 2 3 4 5 ."

do_compile() {
    ${CC} -o userbutton-pressed ${CFLAGS} ${LDFLAGS} flashing/userbutton-pressed.c
}

do_install() {
  TEST_FILES=" \
    testaudio \
    testcamera \
    testdsp \
    testedid \
    testled \
    testmem \
    testneon \
    testsvideo \
    testuserbtn \
    editbootscr \
    edituserscr \
    readgpio \
  "
  install -d ${D}/${bindir}
  for i in ${TEST_FILES}; do
    install -m 0755 ${S}/${i} ${D}/${bindir}
  done
  # A script to flash NAND if the board has it, and if there is valid image to flash on the SD Card.
  # We also register it as an init script so that the SD Card auto-flashes to NAND during boot.
  install -d ${D}/${sysconfdir}/init.d/
  install -m 0755 ${S}/flashing/flash-nand-fs.sh ${D}/${sysconfdir}/init.d/flash-nand-fs.sh
  install -m 0755 userbutton-pressed ${D}/${bindir}/userbutton-pressed
  install -d ${D}/boot/
  install -m 0755 ${S}/flashing/user.txt ${D}/boot/user.txt
  install -m 0755 ${S}/flashing/uEnv.txt ${D}/boot/uEnv.txt
}
