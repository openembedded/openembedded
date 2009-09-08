DESCRIPTION = "Flexible layout classes for Swing and SWT"
LICENSE = "BSD"

AUTHOR = "Mikael Grev"
HOMEPAGE = "http://www.migcalendar.com/miglayout"

SRC_URI = "http://www.migcalendar.com/${PN}/versions/${P}.zip"

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

