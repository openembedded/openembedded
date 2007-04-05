# ex:ts=4:sw=4:sts=4:et
# -*- tab-width: 4; c-basic-offset: 4; indent-tabs-mode: nil -*-
#
#
# Copyright (C)       2005, 2006 Holger Hans Peter Freyther
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

__version__ = "0.0"

import os, sys

class HTMLPage:
    """
    Small utility to create a HTML report page
    """
    def __init__(self):
        self.header   = ""
        self.config   = ""
        self.summary  = []
        self.passed   = []
        self.failed   = []

    def open(self, title):
        """
        The header is taken from JHBuild
        """
        self.header   = """<html>
  <head>
    <title>%(title)s</title>
    <style type="text/css">
      .section {
        margin-after: 1.5em;
      }
      .success {
        color: black;
        background-color: #afa;
      }
      .failure {
        color: black;
        background-color: #faa;
      }
    </style>
  </head>
"""
        pass

    def add_head(self, config):
        pass

    def add_summary(self, count, passed, failed):
        pass

    def add_failed(self, failed):
        pass

    def add_passed(self, failed):
        pass

    def write(self, file):
        pass

class TestReportHTML:
    """
    Output the Test Result as a single HTML Page
    """

    def __init__(self, config, test_name, file):
        self.test_config = test_name

    def init(self, test_result):
        self.test_result = test_result
        self.failed      = []
        self.passed      = []

    def parse_tests(self):
        """
        Parse the tests into the categories Passed and Failed
        """
        for test in self.test_result:
            if test.test_result:
                self.passed.append( test )
            else:
                self.failed.append( test )

    def print_result(self):
        self.parse_tests()
        page = HTMLPage()
        page.open( "Bit Test Result" )
        page.add_head( self.test_config )
        page.add_summary( len(self.test_result), len(self.passed), len(self.failed) )
        page.add_failed( self.failed )
        page.add_passed( self.failed )
        page.write( "result.html" )
