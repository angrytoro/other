package com.pjxy.wap.ui;

import java.io.UnsupportedEncodingException;
import java.util.List;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

// 截取固定宽度的字符串(中文字算2字)
public class FtlSubstringWidth implements TemplateMethodModelEx {
	@Override
	public Object exec(@SuppressWarnings("rawtypes") List args)
			throws TemplateModelException {
		String origin = args.get(0).toString();
		int len = Integer.parseInt(args.get(1).toString());
		try {
			byte[] bs = origin.getBytes("gbk");
			if (bs.length <= len) {
				return origin;
			} else {
				int count = 0;
				for (int i = len - 1; i >= 1; i--) {
					if (bs[i] >= 0) {
						if (count % 2 == 1)
							len--;
						break;
					}
					count++;
				}
				byte[] cp = new byte[len];
				System.arraycopy(bs, 0, cp, 0, len);
				return new String(cp, "gbk");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return origin;
	}
}
