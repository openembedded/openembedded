DESCRIPTION = "Encrypted shellscript for the Zaurus ROM update"
DEPENDS = "encdec-updater-native"
LICENSE = "zaurus-updater"
PR = "r7"

SRC_URI = "file://updater.sh \
           file://gnu-tar.gz"
S = "${WORKDIR}"

do_compile() {
	encdec-updater -e updater.sh
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
	install -m 0755 updater.sh ${DEPLOY_DIR_IMAGE}/updater.sh

	case ${MACHINE} in
		spitz )
			install -m 0755 gnu-tar ${DEPLOY_DIR_IMAGE}/gnu-tar
			;;
        	*)
			;;
	esac
}

addtask deploy before do_package after do_compile
