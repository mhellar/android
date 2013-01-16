package pete.android.study.provider;

import android.net.Uri;
import android.provider.BaseColumns;

public class ArticleMetaData {
	private ArticleMetaData() { }
	
	public static final String AUTHORITY = "pete.android.study.provider.Articles";
	public static final Uri CONTENT_URI = Uri.parse(
		"content://" + AUTHORITY + "/articles"
	);
	
	public static final String DATABASE_NAME = "articles.db";
	public static final int DATABSE_VERSION = 1;
	
	public static final String CONTENT_TYPE_ARTICLES_LIST = "vnd.android.cursor.dir/vnd.pete.articles";
	public static final String CONTENT_TYPE_ARTICLE_ONE = "vnd.android.cursor.item/vnd.pete.articles";
	
	public class ArticleTable implements BaseColumns {
		private ArticleTable() { }
		
		public static final String TABLE_NAME = "tbl_articles";
		
		public static final String ID = "_id";
		public static final String TITLE = "title";
		public static final String CONTENT = "content";
	}
	
}
