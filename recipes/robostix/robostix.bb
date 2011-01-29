DESCRIPTION = "Robostix programs"
PRIORITY = "optional"
SECTION = "base"
LICENSE = "GPL"
RDEPENDS_${PN} = "kernel-${KERNEL_VERSION}"
DEPENDS = "virtual/kernel"

PR = "r1"

SRC_URI = "svn://svn.gumstix.com/gumstix-buildroot/branches/projects;module=robostix;rev=1588;proto=http \
   file://makefile-rules.patch \
   file://gummake.patch \
   "

S = "${WORKDIR}/robostix"

inherit module-base

EXTRA_OEMAKE = 'CROSS_COMPILE="${CROSS_COMPILE}" \
                KERNELDIR="${KERNEL_SOURCE}" \
                CC="${CC}" \
                '

PARALLEL_MAKE = ""

do_configure () {
	echo "Nothing to configure for robostix"
}

do_compile () {
   unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
   cd ${S}
   make
   cd ${S}/gumstix
	oe_runmake
   cd ${S}/gumstix/i2c-io
	oe_runmake
   cd ${S}/gumstix/i2c-load
	oe_runmake
   cd ${S}/gumstix/i2c
	oe_runmake
}

do_install () {
   # install programs to bindir
   install -m 0755 -d ${D}${bindir}
	install -m 0755  ${S}/gumstix/i2c-io/i2c-io ${D}${bindir}
   install -m 0755  ${S}/gumstix/i2c-load/i2c-load ${D}${bindir}
   install -m 0755  ${S}/gumstix/i2c/i2c ${D}${bindir}
   install -m 0755  ${S}/gumstix/robostix ${D}${bindir}
   install -m 0755  ${S}/gumstix/sertest ${D}${bindir}

   # kernel module installs with other modules, but use
   # cp instead of install so its not stripped
   install -m 0755 -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
   cp ${S}/gumstix/robostix_drv.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/

   # avr hex programs install to /root
   install -m 0755 -d ${D}/root
   install -m 0755  ${S}/ArgTest/ArgTest.hex ${D}/root
   install -m 0755  ${S}/Flash-LED/Flash-LED.hex ${D}/root
   install -m 0755  ${S}/i2c-BootLoader/i2c-Boot-m128-16MHz.hex ${D}/root
   install -m 0755  ${S}/i2c-BootLoader/i2c-Boot-m128-16MHz-eep.hex ${D}/root
   install -m 0755  ${S}/i2c-io/i2c-io.hex ${D}/root
   install -m 0755  ${S}/i2c-test/i2c-test.hex ${D}/root
   install -m 0755  ${S}/int6/int6.hex ${D}/root
   install -m 0755  ${S}/LCD-Test/LCD-Test.hex ${D}/root
   install -m 0755  ${S}/QD-Test/QD-Test.hex ${D}/root
   install -m 0755  ${S}/RCInput/RC-Test.hex ${D}/root
   install -m 0755  ${S}/Simple-Flasher/Simple-Flasher.hex ${D}/root
   install -m 0755  ${S}/Simple-Servo/Simple-Servo.hex ${D}/root
   install -m 0755  ${S}/Simple-Servo-2/Simple-Servo-2.hex ${D}/root
   install -m 0755  ${S}/Tachometer/Tachometer.hex ${D}/root
}

PACKAGES = "${PN}-i2c-io"
FILES_${PN}-i2c-io = "${bindir}/i2c-io"

PACKAGES += "${PN}-i2c-load"
FILES_${PN}-i2c-load = "${bindir}/i2c-load"

PACKAGES += "${PN}-i2c"
FILES_${PN}-i2c = "${bindir}/i2c"

PACKAGES += "${PN}-sertest"
FILES_${PN}-sertest = "${bindir}/sertest"

PACKAGES += "${PN}-usermode"
FILES_${PN}-usermode = "${bindir}/robostix"

PACKAGES += "${PN}-kernel-module"
FILES_${PN}-kernel-module = "${base_libdir}/modules/${KERNEL_VERSION}/extra/robostix_drv.ko"

PACKAGES += "${PN}-avr-ArgTest"
FILES_${PN}-avr-ArgTest = "/root/ArgTest.hex"

PACKAGES += "${PN}-avr-Flash-LED"
FILES_${PN}-avr-Flash-LED = "/root/Flash-LED.hex"

PACKAGES += "${PN}-avr-i2c-BootLoader"
FILES_${PN}-avr-i2c-BootLoader = "/root/i2c-Boot-m128-16MHz.hex"

PACKAGES += "${PN}-avr-i2c-BootLoader-eep"
FILES_${PN}-avr-i2c-BootLoader-eep = "/root/i2c-Boot-m128-16MHz-eep.hex"

PACKAGES += "${PN}-avr-i2c-io"
FILES_${PN}-avr-i2c-io = "/root/i2c-io.hex"

PACKAGES += "${PN}-avr-i2c-test"
FILES_${PN}-avr-i2c-test = "/root/i2c-test.hex"

PACKAGES += "${PN}-avr-int6"
FILES_${PN}-avr-int6 = "/root/int6.hex"

PACKAGES += "${PN}-avr-LCD-Test"
FILES_${PN}-avr-LCD-Test = "/root/LCD-Test.hex"

PACKAGES += "${PN}-avr-QD-Test"
FILES_${PN}-avr-QD-Test = "/root/QD-Test.hex"

PACKAGES += "${PN}-avr-RC-Test"
FILES_${PN}-avr-RC-Test = "/root/RC-Test.hex"

PACKAGES += "${PN}-avr-Simple-Flasher"
FILES_${PN}-avr-Simple-Flasher = "/root/Simple-Flasher.hex"

PACKAGES += "${PN}-avr-Simple-Servo"
FILES_${PN}-avr-Simple-Servo = "/root/Simple-Servo.hex"

PACKAGES += "${PN}-avr-Simple-Servo-2"
FILES_${PN}-avr-Simple-Servo-2 = "/root/Simple-Servo-2.hex"

PACKAGES += "${PN}-avr-Tachometer"
FILES_${PN}-avr-Tachometer = "/root/Tachometer.hex"

