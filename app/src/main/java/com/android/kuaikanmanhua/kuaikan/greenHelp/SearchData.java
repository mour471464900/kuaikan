package com.android.kuaikanmanhua.kuaikan.greenHelp;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "SEARCH_DATA".
 */
public class SearchData {

    private Long id;
    /** Not-null value. */
    private String record;
    private Integer position;

    public SearchData() {
    }

    public SearchData(Long id) {
        this.id = id;
    }

    public SearchData(Long id, String record, Integer position) {
        this.id = id;
        this.record = record;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getRecord() {
        return record;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setRecord(String record) {
        this.record = record;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
