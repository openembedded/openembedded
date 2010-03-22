inherit src_distribute

SRC_DIST_LOCAL ?= "move+symlink"
SRC_DISTRIBUTEDIR ?= "${DEPLOY_DIR}/sources"
SRC_DISTRIBUTECOMMAND[dirs] = "${SRC_DISTRIBUTEDIR}/${LIC}/${PN}"

# symlinks the files to the SRC_DISTRIBUTEDIR
SRC_DISTRIBUTECOMMAND-symlink () {
    test -e "${SRC}.md5" && ln -sf "${SRC}.md5" .
    ln -sf "${SRC}" .
}

# copies the files to the SRC_DISTRIBUTEDIR
SRC_DISTRIBUTECOMMAND-copy () {
    test -e "${SRC}.md5" && cp -f "${SRC}.md5" .
    cp -fr "${SRC}" .
}

# moves the files to the SRC_DISTRIBUTEDIR and symlinks them back
SRC_DISTRIBUTECOMMAND-move+symlink () {
    if ! [ -L ${SRC} ]; then
        src=`basename "${SRC}"`
        mv ${SRC} .
        ln -sf $src "${SRC}"
        if [ -e ${SRC}.md5 ]; then
            mv ${SRC}.md5 .
            ln -sf $src "${SRC}.md5"
        fi
    fi
}

#SRC_DISTRIBUTECOMMAND = "${@str(d.getVar('SRC_DISTRIBUTECOMMAND-%s' % d.getVar('SRC_DIST_LOCAL', 1), 1))}"
python () {
    if d.getVar("SRC_DISTRIBUTECOMMAND", 1) is None:
        cmd = d.getVar("SRC_DISTRIBUTECOMMAND-%s" % d.getVar("SRC_DIST_LOCAL", 1), 0)
        if cmd:
            d.setVar("SRC_DISTRIBUTECOMMAND", cmd)
}
