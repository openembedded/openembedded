SECTION="base"
PRIORITY="required"
MAINTAINER="Greg Gilbert <greg@treke.net>"
DEPENDS=zlib tslib ncurses

SRC_URI = "ftp://ftp.xfree86.org/pub/XFree86/4.3.0/source/X430src-1.tgz;"
SRC_URI_append =" ftp://ftp.xfree86.org/pub/XFree86/4.3.0/source/X430src-2.tgz;"
SRC_URI_append =" ftp://ftp.xfree86.org/pub/XFree86/4.3.0/source/X430src-3.tgz;"
SRC_URI_append =" file://${FILESDIR}/tinyx-kbd-enable-fix.patch;patch=1"
SRC_URI_append =" file://${FILESDIR}/tinyx-tslib-reset-and-vt-switch-fixes.patch;patch=1"
SRC_URI_append =" file://${FILESDIR}/dirty-3.2-xterm-breakage-fix.patch;patch=1"

S=${WORKDIR}/xc


do_configure() {
    rm -fr ${WORKDIR}/XXcompiler; 
    mkdir -p ${WORKDIR}/XXcompiler 
    pushd ./ 
    cd ${CROSS_DIR}/bin/; 
    echo ${CC}
    for i in *; do  
       echo " linking ${WORKDIR}/XXcompiler/$i to $i"; 
            ln -s ${CROSS_DIR}/bin/$i ${WORKDIR}/XXcompiler/$i ; 
            toolname=`echo $i | sed s/${TARGET_ARCH}-${TARGET_OS}-//`
            echo `echo $i | sed s/${TARGET_ARCH}-${TARGET_OS}-//`
            echo " linking ${WORKDIR}/XXcompiler/$i to $toolname"; 
            ln -s ${CROSS_DIR}/bin/$i ${WORKDIR}/XXcompiler/$toolname; 
    done                                   
    echo "#!/bin/sh" >  ${WORKDIR}/XXcompiler/cc
    echo "${CC} \$*" >> ${WORKDIR}/XXcompiler/cc
    chmod 755 ${WORKDIR}/XXcompiler/cc
    popd ;
        

}

XCURSORGEN=/usr/local/X11R6/bin/xcursorgen
EXTRA_OEMAKE="-C ${S} CC='${BUILD_CC}' \
	      CROSSCOMPILEDIR='${WORKDIR}/XXcompiler' \
	      EXTRA_LDOPTIONS='${LDFLAGS}' \
	      EXTRA_INCLUDES='-I${STAGING_DIR}/target/include' "
do_compile() {
    sed -e "s/^\#define KdriveServerExtraDefines -DITSY -DMAXSCREENS=2 -DXResExtension.*/\#define KdriveServerExtraDefines -DITSY -DMAXSCREENS=2 -DXResExtension ${FULL_OPTIMIZATION}/" < ${FILESDIR}/host.def > ${S}/config/cf/host.def; 

    oe_runmake  World

}

do_install() {
    oe_runmake DESTDIR=${D} install

}
