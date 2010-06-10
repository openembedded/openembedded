DESCRIPTION = "Necessary packages for development at runtime environment"
LICENSE = "MIT"
PR = "r4"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
  task-mamona \
  gdb \
  strace \
  udev-usbserial \
  usbnet \
  openssh-sshd \
  openssh-scp \
"

pkg_postinst () {
	echo; echo
	echo " ########################################################## "
	echo " # WARNING: Please set your root password before use your # "
	echo " #          usbnet package. It's required for ssh login.  # "
	echo " ########################################################## "
	echo; echo
}

