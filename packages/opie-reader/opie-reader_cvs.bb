include ${PN}.inc
    
PV = "1.2.0+cvs-${CVSDATE}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

DEPENDS += " flite "
EXTRA_QMAKEVARS_POST += " SUBDIRS+=FliteDyn SUBDIRS+=FliteDyn16 "

python populate_packages_prepend () {
        print "opie-reader:", bb.data.getVar( 'RDEPENDS_opie-reader', d )
        plugindir = bb.data.expand('${palmtopdir}/plugins/reader', d)                                     
        for dir, type in [ ( 'codecs', 'codec' ), ( 'filters', 'filter' ), ( 'outcodecs', 'output' ) ]:
            dir = plugindir + '/' + dir
            do_split_packages(d, dir,
                              '^lib(.*)\.so$', 'opie-reader-' + type + '-%s',
                              'Opie reader %s ' + type,
                              prepend=True)

        # input codes are small and should be installed together with opie-reader,
        # flite output pulls in libflite and thus should only be installed if
        # really wanted by the user
        suggests=[]
        recommends=[]
        for package in bb.data.getVar('PACKAGES', d).split():
            if 'flite' in package:
                suggests.append(package)
            else:
                recommends.append(package)
        bb.data.setVar('RRECOMMENDS_opie-reader', " ".join( recommends ), d)
        bb.data.setVar('RSUGGESTS_opie-reader', " ".join( suggests ), d)
}
