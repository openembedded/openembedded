# Copyright (C) 2009, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DEPENDS = "unzip-native"
RDEPENDS_${PN} = "firefox"

S = "${WORKDIR}"
FIREFOX_VERSION = "3.0.4"

do_configure() {
	unzip -o -q -d xpi *.xpi
}

INC_PR = "r2"

do_install() {
	cd ${S}/xpi

	if [ -z ${EXTENSION} ]; then
	   echo "You NEED to define EXTENSION in your recipe. Exiting"
	   exit 1
	fi

	mkdir -p ${D}/usr/lib/firefox-${FIREFOX_VERSION}/extensions/${EXTENSION}/chrome
	mkdir -p ${D}/usr/lib/firefox-${FIREFOX_VERSION}/extensions/${EXTENSION}/uninstall
	install -m 644 chrome/*.jar ${D}/usr/lib/firefox-${FIREFOX_VERSION}/extensions/${EXTENSION}/chrome
	install -m 644 install.rdf ${D}/usr/lib/firefox-${FIREFOX_VERSION}/extensions/${EXTENSION}
	install -m 644 chrome.manifest ${D}/usr/lib/firefox-${FIREFOX_VERSION}/extensions/${EXTENSION}

	cat install.rdf > ${D}/usr/lib/firefox-${FIREFOX_VERSION}/extensions/${EXTENSION}/uninstall/Uninstall
}

FILES_${PN} += "/usr/lib/firefox-${FIREFOX_VERSION}"
PACKAGE_ARCH = "all"
