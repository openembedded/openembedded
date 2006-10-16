def gtkbinver_find(d):
    import bb
    try:
        for line in file( "%s/pkgconfig/gtk+-2.0.pc" % bb.data.getVar('STAGING_DATADIR', d, 1) ).readlines():
            if line.startswith( "gtk_binary_version" ):
                # bb.note( "gtk_binary_version = '%s'" % line.split("=")[1].strip() )
                return line.split("=")[1].strip()
    except OSError:
        return "0.0.0"
