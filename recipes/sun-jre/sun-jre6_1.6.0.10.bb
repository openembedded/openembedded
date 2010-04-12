DESCRIPTION = "Sun J2SE Runtime Environment"
LICENSE = "Sun Binary Code License Agreement"
RDEPENDS_${PN} += "libx11-locale"
RDEPENDS_${PN}-plugin += "${PN}"
PR = "r1"
PRIVATE_LIBS = "${@base_read_file('${WORKDIR}/${SD}.shlibs')}"

SRC_URI = "http://download.java.net/dlj/binaries/jdk-6u10-dlj-linux-i586.bin"

SP = "jdk-6u10-dlj-linux-i586.bin"
SD = "jdk1.6.0_10"
S = "${WORKDIR}"

do_install() {
    export MORE=10000
    sh ${WORKDIR}/${SP} --accept-license >/dev/null
    chmod -R go=u-w ${SD}
    chmod -R u+w ${SD}
    mkdir -p ${D}${libdir}/sun-java6-${PV}
    mv ${S}/${SD}/jre/* ${D}${libdir}/sun-java6-${PV}
    mkdir -p ${D}${libdir}/mozilla/plugins
    cd ${D}${libdir}/mozilla/plugins
    ln -s ${libdir}/sun-java6-${PV}/plugin/i386/ns7/libjavaplugin_oji.so .
    cd ${D}${libdir}/sun-java6-${PV}
    for p in `find . -name '*.pack'`; do
    ./bin/unpack200 $p $(echo $p | sed 's,.pack$,.jar,g') || exit 1
    rm $p
    done
    for i in bin/ControlPanel \
             bin/javaws       \
             bin/jcontrol     \
             bin/keytool      \
             bin/orbd         \
             bin/pack200      \
             bin/policytool   \
             bin/rmid         \
             bin/rmiregistry  \
             bin/servertool   \
             bin/tnameserv    \
             bin/unpack200
    do
    rm $i
    done
    rm -rf javaws lib/javaws*
    rm -rf plugin/desktop plugin/i386/ns7-gcc29
    rm -f lib/fontconfig.*.bfc lib/fontconfig.*.properties.src
    rm -f lib/javaws.jar lib/ext/ldapsec.jar lib/cmm/PYCC.pf \
        lib/audio/soundbank.gm
    rm -rf lib/i386/server lib/i386/motif21 lib/i386/client/classes.jsa \
        lib/i386/libjavaplugin_nscp_gcc29.so \
        lib/i386/headless
    rm -rf fonts oblique-fonts man
    rm -rf lib/locale lib/zi lib/management
    rm -rf lib/desktop LICENSE README COPYRIGHT THIRDPARTYLICENSEREADME.txt \
        Welcome.html
    # Find out what shared libs we contain and spit it out to a file
    find . -name "*.so" -exec basename {} \; | sort | uniq > ${WORKDIR}/${SD}.shlibs
}

PACKAGES =+ "${PN}-plugin"
FILES_${PN} = "/usr/"
FILES_${PN}-dbg += "/usr/*/.debug /usr/*/*/.debug /usr/*/*/*/.debug /usr/*/*/*/*/.debug /usr/*/*/*/*/*/.debug"
FILES_${PN}-plugin = "${libdir}/mozilla/plugins/* ${libdir}/sun-java6-${PV}/plugin/i386/ns7/libjavaplugin_oji.so"

pkg_postinst_${PN} () {
                grep -v JAVA_HOME /etc/environment > /etc/environment.new
                mv /etc/environment.new /etc/environment
                echo "JAVA_HOME=\"${libdir}/sun-java6-${PV}\"" >> /etc/environment
}

COMPATIBLE_HOST = "i.86.*-linux"

SRC_URI[md5sum] = "b70924c697584ab7955050d7a9b4de57"
SRC_URI[sha256sum] = "dae79e8c56090ac3fb4ac3fe0df9faf6a0c9694a89ef978dce0ab970557ad264"
