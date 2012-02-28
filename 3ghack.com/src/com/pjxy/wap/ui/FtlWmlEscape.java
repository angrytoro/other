package com.pjxy.wap.ui;

import java.util.List;

import com.pjxy.wap.util.WmlSyntaxAnalyser;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class FtlWmlEscape implements TemplateMethodModelEx {
	@Override
	public Object exec(@SuppressWarnings("rawtypes") List args)
			throws TemplateModelException {
		return WmlSyntaxAnalyser.plainTextFilter(args.get(0).toString());
	}

}
