# Copyright (C) 2009, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license (see packages/COPYING)

def get_language_name(package):
    lang = package.replace('firefox-l10n-', '')

    if lang.find('-'):
        lang = lang.split('-')
        lang[1] = lang[1].upper()
        lang = '-'.join(lang)

    return lang

DEPENDS = "unzip-native"
RDEPENDS_${PN} = "firefox"
LANGUAGE = "${@get_language_name('${PN}')}"

SRC_URI = "http://releases.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/linux-i686/xpi/${LANGUAGE}.xpi"
S = "${WORKDIR}"

do_configure() {
	unzip -o -q -d ${LANGUAGE} ${LANGUAGE}.xpi
}

INC_PR = "r2"

do_install() {
	cd ${S}/${LANGUAGE}

	# Get extension UUID
	EXTENSION=`cat install.rdf | sed --posix '/em:id=/!d;s/[ ]*em:id="//;s/".*//'`

	mkdir -p ${D}/usr/lib/firefox-${PV}/extensions/${EXTENSION}/chrome
	mkdir -p ${D}/usr/lib/firefox-${PV}/extensions/${EXTENSION}/uninstall
	install -m 644 chrome/*.jar ${D}/usr/lib/firefox-${PV}/extensions/${EXTENSION}/chrome
	install -m 644 install.rdf ${D}/usr/lib/firefox-${PV}/extensions/${EXTENSION}
	install -m 644 chrome.manifest ${D}/usr/lib/firefox-${PV}/extensions/${EXTENSION}

	cat install.rdf \
	   | sed --posix '/<em:locale>/!d' \
	   | sed --posix "s/.*/register      global  locale  ${LANGUAGE}/" \
	   > ${D}/usr/lib/firefox-${PV}/extensions/${EXTENSION}/uninstall/Uninstall
}

FILES_${PN} += "/usr/lib/firefox-${PV}"
PACKAGE_ARCH = "all"
