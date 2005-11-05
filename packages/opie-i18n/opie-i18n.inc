DESCRIPTION = "Opie i18n files"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-lrelease-native"


S = "${WORKDIR}/i18n"

do_compile() {
	for f in ?? ??_??
	do
		cd ${S}/$f
		for g in *.ts
		do
			opie-lrelease $g
		done
	done
}

do_install() {
	install -d ${D}${palmtopdir}/i18n/
	install -d ${D}${palmtopdir}/etc/dict/
	for f in ?? ??_??
	do
		echo Installing language $f
		install -d ${D}${palmtopdir}/i18n/$f/
		install -m 0644 $f/.directory ${D}${palmtopdir}/i18n/$f/
		install -m 0644 $f/*.qm ${D}${palmtopdir}/i18n/$f/
		if [ -e ${WORKDIR}/dict/dawg.$f ]
		then
			install -m 0644 ${WORKDIR}/dict/dawg.$f ${D}${palmtopdir}/etc/dict/
		fi
		install -m 0644 ${WORKDIR}/dict/dawg ${D}${palmtopdir}/etc/dict/
	done
}

PACKAGES = "opie-i18n-cz  opie-i18n-da  opie-i18n-de  opie-i18n-dk  opie-i18n-en  opie-i18n-es \
opie-i18n-fr  opie-i18n-hu opie-i18n-it  opie-i18n-ja  opie-i18n-ko  opie-i18n-lv  opie-i18n-mk \
opie-i18n-nl  opie-i18n-no  opie-i18n-pl opie-i18n-pt  opie-i18n-pt-br  opie-i18n-ru  opie-i18n-sl \
opie-i18n-xx  opie-i18n-zh-cn  opie-i18n-zh-tw \
opie-dict-cz  opie-dict-da  opie-dict-de  opie-dict-dk  opie-dict-en  opie-dict-es \
opie-dict-fr  opie-dict-hu opie-dict-it  opie-dict-ja  opie-dict-ko  opie-dict-lv  opie-dict-mk \
opie-dict-nl  opie-dict-no  opie-dict-pl opie-dict-pt  opie-dict-pt-br  opie-dict-ru  opie-dict-sl \
opie-dict-xx  opie-dict-zh-cn  opie-dict-zh-tw "

FILES_opie-dict-cz = "${palmtopdir}/etc/dict/dawg.cz"
FILES_opie-dict-da = "${palmtopdir}/etc/dict/dawg.da"
FILES_opie-dict-de = "${palmtopdir}/etc/dict/dawg.de"
FILES_opie-dict-dk = "${palmtopdir}/etc/dict/dawg.dk"
FILES_opie-dict-en = "${palmtopdir}/etc/dict/dawg"
FILES_opie-dict-es = "${palmtopdir}/etc/dict/dawg.es"
FILES_opie-dict-fr = "${palmtopdir}/etc/dict/dawg.fr"
FILES_opie-dict-hu = "${palmtopdir}/etc/dict/dawg.hu"
FILES_opie-dict-it = "${palmtopdir}/etc/dict/dawg.it"
FILES_opie-dict-ja = "${palmtopdir}/etc/dict/dawg.ja"
FILES_opie-dict-ko = "${palmtopdir}/etc/dict/dawg.ko"
FILES_opie-dict-lv = "${palmtopdir}/etc/dict/dawg.lv"
FILES_opie-dict-mk = "${palmtopdir}/etc/dict/dawg.mk"
FILES_opie-dict-nl = "${palmtopdir}/etc/dict/dawg.nl"
FILES_opie-dict-no = "${palmtopdir}/etc/dict/dawg.no"
FILES_opie-dict-pl = "${palmtopdir}/etc/dict/dawg.pl"
FILES_opie-dict-pt-br = "${palmtopdir}/etc/dict/dawg.pt_BR"
FILES_opie-dict-pt = "${palmtopdir}/etc/dict/dawg.pt"
FILES_opie-dict-ru = "${palmtopdir}/etc/dict/dawg.ru"
FILES_opie-dict-sl = "${palmtopdir}/etc/dict/dawg.sl"
FILES_opie-dict-xx = "${palmtopdir}/etc/dict/dawg.xx"
FILES_opie-dict-zh-cn = "${palmtopdir}/etc/dict/dawg.zh_CN"
FILES_opie-dict-zh-tw = "${palmtopdir}/etc/dict/dawg.zh_TW"

FILES_opie-i18n-cz = "${palmtopdir}/i18n/cz"
FILES_opie-i18n-da = "${palmtopdir}/i18n/da"
FILES_opie-i18n-de = "${palmtopdir}/i18n/de"
FILES_opie-i18n-dk = "${palmtopdir}/i18n/dk"
FILES_opie-i18n-en = "${palmtopdir}/i18n/en"
FILES_opie-i18n-es = "${palmtopdir}/i18n/es"
FILES_opie-i18n-fr = "${palmtopdir}/i18n/fr"
FILES_opie-i18n-hu = "${palmtopdir}/i18n/hu"
FILES_opie-i18n-it = "${palmtopdir}/i18n/it"
FILES_opie-i18n-ja = "${palmtopdir}/i18n/ja"
FILES_opie-i18n-ko = "${palmtopdir}/i18n/ko"
FILES_opie-i18n-lv = "${palmtopdir}/i18n/lv"
FILES_opie-i18n-mk = "${palmtopdir}/i18n/mk"
FILES_opie-i18n-nl = "${palmtopdir}/i18n/nl"
FILES_opie-i18n-no = "${palmtopdir}/i18n/no"
FILES_opie-i18n-pl = "${palmtopdir}/i18n/pl"
FILES_opie-i18n-pt-br = "${palmtopdir}/i18n/pt_BR"
FILES_opie-i18n-pt = "${palmtopdir}/i18n/pt"
FILES_opie-i18n-ru = "${palmtopdir}/i18n/ru"
FILES_opie-i18n-sl = "${palmtopdir}/i18n/sl"
FILES_opie-i18n-xx = "${palmtopdir}/i18n/xx"
FILES_opie-i18n-zh-cn = "${palmtopdir}/i18n/zh_CN"
FILES_opie-i18n-zh-tw = "${palmtopdir}/i18n/zh_TW"
