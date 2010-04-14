DESCRIPTION = "Flexible layout classes for Swing and SWT"
LICENSE = "BSD"

AUTHOR = "Mikael Grev"
HOMEPAGE = "http://www.migcalendar.com/miglayout"

SRC_URI = "http://www.migcalendar.com/${PN}/versions/older/${P}.zip"

SRC_URI[md5sum] = "54206117ba825610ace893cebd760ac4"
SRC_URI[sha256sum] = "ff7e95e84573ae4ec5a666950a5c07f83d607e7c992c05532729df2a559bc6a2"

S = "${WORKDIR}"

inherit java-library

DEPENDS = "fastjar-native classpath swt3.4-gtk"
do_unpack[depends] += "unzip-native:do_populate_staging"

do_unpackpost() {
	find -name "*.jar" -exec rm {} \;

	mkdir sources
	unzip miglayout-src.zip -d sources
}

addtask unpackpost after do_unpack before do_patch

do_compile() {
  oe_makeclasspath cp -s swt

  javac \
    -source 5.0 -sourcepath sources -cp $cp \
    -d build \
    `find sources -name "*.java" -and -not -wholename "*demo*"` \

  fastjar -C build -c -f ${JARFILENAME} .
}

