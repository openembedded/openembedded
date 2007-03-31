#
# Helper utilitiy to verify checksums of SRC_URI's
#
#  To ease parsing I will use INI files to contain the
#  checksums, at least they will force some kind of structure. This allows
#  to easily add and replace new sums
#
#
#  Example:
#  [PN-PV-filename]
#  md5=THESUM
#  sha256=OTHERSUM
#
#  [PN-filename]
#  md5=THESUM
#  sha256=OTHERSUM


def verify_file(config_path, pn, pv, src_uri, localpath):
    """
    Verify using the INI file at config_path and check that
    the localpath matches the one specified by the PN-PV-SRCURI
    inside the ini file
    """
    import ConfigParser, os
    parser = ConfigParser.ConfigParser()
    if not len(parser.read(config_path)) == 1:
        raise Exception("Can not open the '%s'" % config_path)

    # Try PN-PV-SRC_URI first and then try PN-SRC_URI
    # we rely on the get method to create errors
    pn_pv_src = "%s-%s-%s" % (pn,pv,src_uri)
    pn_src    = "%s-%s" % (pn,src_uri)
    if parser.has_section(pn_pv_src):
        md5    = parser.get(pn_pv_src, "md5")
        sha256 = parser.get(pn_pv_src, "sha256")
    elif parser.has_section(pn_src):
        md5    = parser.get(pn_src, "md5")
        sha256 = parser.get(pn_src, "sha256")
    else:
        raise Exception("Can not find a section for '%s' '%s' and '%s'" % (pn,pv,src_uri))

    # md5 and sha256 should be valid now
    if not os.path.exists(localpath):
        raise Exception("The path does not exist '%s'" % localpath)


    # call md5(sum) and shasum
    try:
        md5pipe = os.popen('md5sum ' + localpath)
        md5data = (md5pipe.readline().split() or [ "" ])[0]
        md5pipe.close()
    except OSError:
        raise Exception("Executing md5sum failed")

    try:
        shapipe = os.popen('shasum -a256 -p ' + localpath)
        shadata = (shapipe.readline().split() or [ "" ])[0]
        shapipe.close()
    except OSError:
        raise Exception("Executing shasum failed")

    if not md5 == md5data:
        raise Exception("MD5 Sums do not match. Wanted: '%s' Got: '%s'" % (md5, md5data))

    if not sha256 == shadata:
        raise Exception("SHA256 Sums do not match. Wanted: '%s' Got: '%s'" % (sha256, shadata))


    return True


# Test it
verify_file("sample.conf", "qtopia-core", "4.3.0", "ftp://ftp.trolltech.com/qt/source/qtopia-core-opensource-4.2.3.tar.gz", "test.file")
