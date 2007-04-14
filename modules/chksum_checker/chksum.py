# ex:ts=4:sw=4:sts=4:et
# -*- tab-width: 4; c-basic-offset: 4; indent-tabs-mode: nil -*-
#
#
# Copyright (C)       2007 Holger Hans Peter Freyther
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
#   Redistributions of source code must retain the above copyright notice,
#   this list of conditions and the following disclaimer.
#
#   Redistributions in binary form must reproduce the above copyright
#   notice, this list of conditions and the following disclaimer in the
#   documentation and/or other materials provided with the distribution.
#
#   Neither the name Holger Hans Peter Freyther nor the names of its
#   contributors may be used to endorse or promote products derived
#   from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
# (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
# SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
# HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
# STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
# IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
# POSSIBILITY OF SUCH DAMAGE.

from bittest import TestItem

import bb, os

class TestCase:
    """
    A simple test case
    """

    def __init__(self):
        """
        Construct and initialize the test case
        """

    def setup(self, config):
        self.checksum_tuple_dict = {}

    def finish(self, config):
        f = file("checksums.ini", "w+")
        keys = self.checksum_tuple_dict.keys()
        keys.sort()
        for fi in keys:
            (md5,sha) = self.checksum_tuple_dict[fi]
            print >> f, "[%s]" % fi
            print >> f, "md5=%s" % md5
            print >> f, "sha256=%s" % sha
            print >> f, ""

    def test(self,file_name, file_data):
        """
        Now run the test for file_name and the corresponding data. 
        You can use whatever you want
        """

        uris = (bb.data.getVar("SRC_URI", file_data, True) or "").split()
        bb.fetch.init(uris, file_data)
        for uri in uris:
            localpath = bb.fetch.localpath(uri, file_data)
            (type,host,path,_,_,_) = bb.decodeurl(uri)
            uri = "%s://%s%s" % (type,host,path)

            if not type in ["http", "ftp", "https"]:
                continue
            if not uri in self.checksum_tuple_dict and os.path.exists(localpath):
                md5sum = os.popen("md5sum    %s" % localpath).read().split()[0]
                shasum = os.popen("sha256sum %s" % localpath).read().split()[0]
                self.checksum_tuple_dict[uri] = (md5sum,shasum)

        return TestItem(file_name,True, "Psst, we did not test at all")

    def test_name(self):
        """
        Retutnr a name for the test
        """
        return "Create a checksum file"
